import React, { useEffect, useState } from 'react';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import { useHistory } from 'react-router-dom';

import api from '../../services/api';

import './styles.css';

function Funcionarios() {
  
  const [ funcionarios, setFuncionarios ] = useState([]);

  const [nome, setNome] = useState('');
  const [cpf, setCPF] = useState('');
  const [rg, setRG] = useState('');
  const [rua, setRua] = useState('');
  const [numero, setNumero] = useState(0);
  const [bairro, setBairro] = useState('');
  const [complemento, setComplemento] = useState('');
  const [cep, setCEP] = useState('');
  const [cidade, setCidade] = useState('');
  const [uf, setUF] = useState('');
  const [pais, setPais] = useState('');
  const [telefone, setTelefone] = useState('');
  const [celular, setCelular] = useState('');
  const [email, setEmail] = useState('');
  const [admissao, setAdmissao] = useState(0);
  const [salario, setSalario] = useState(0);

  const history = useHistory();

  async function handleNewFuncionarios(e){
    const data = {
      nome: nome,
      cpf: cpf,
      rg: rg,
      rua: rua,
      numero: numero,
      bairro: bairro,
      complemento: complemento,
      cep: cep,
      cidade: cidade,
      uf: uf,
      pais: pais,
      telefone: telefone,
      celular: celular,
      email: email,
      admissao: admissao,
      salario: salario,
    };
    try{
      await api.post('/funcionarios', data);
      history.push('/funcionarios');
      console.log(data);
    }catch (err){
      alert('ERROR');
    }
  }

  useEffect(() => {
    api.get('/funcionarios').then(response => {
      setFuncionarios(response.data)
    })
  });

  async function handleDeletFuncionario(id) {
    try{
        await api.delete(`/funcionarios/${id}`);
  
        setFuncionarios(funcionarios.filter(funcionario => funcionario.id_funcionario !== id));
    }catch{
      alert('erro ao deletar');
    }
  }

  return(
    <>
    <Header menu = {true}/>
    <div id="principal">
      <div className="card">
      <form onSubmit={handleNewFuncionarios}>
        <h1>Cadastro de funcionários</h1>
        <h2>Dados do funcionario:</h2>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setNome(e.target.value)}
            type="text"
            placeholder="Nome"/>
          </div>

          <div className="input">
            <input 
            type="text"
            onChange={e => setRG(e.target.value)}
            placeholder="RG"/>
          </div>
        </div>

        <div className="row">
          <div className="input">
            <input 
            onChange={e => setCPF(e.target.value)}
            type="text"
            placeholder="CPF"/>
          </div>
        </div>

        <h2>Endereço:</h2>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setRua(e.target.value)}
            type="text"
            placeholder="Rua"/>
          </div>
          <div className="input">
            <input 
            onChange={e => setNumero(e.target.value)}
            type="number"
            placeholder="Numero"/>
          </div>
        </div>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setBairro(e.target.value)}
            type="text"
            placeholder="Bairro"/>
          </div>
          <div className="input">
            <input 
            onChange={e => setComplemento(e.target.value)}
            type="text"
            placeholder="Complemento"/>
          </div>
        </div>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setCEP(e.target.value)}
            type="text"
            placeholder="CEP"/>
          </div>
          <div className="input">
            <input 
            onChange={e => setCidade(e.target.value)}
            type="text"
            placeholder="Cidade"/>
          </div>
        </div>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setUF(e.target.value)}
            type="text"
            placeholder="UF"/>
          </div>
          <div className="input">
            <input 
            onChange={e => setPais(e.target.value)}
            type="text"
            placeholder="País"/>
          </div>
        </div>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setTelefone(e.target.value)}
            type="text"
            placeholder="Telefone"/>
          </div>
          <div className="input">
            <input 
            onChange={e => setCelular(e.target.value)}
            type="text"
            placeholder="Celular"/>
          </div>
        </div>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setEmail(e.target.value)}
            type="text"
            placeholder="E-mail"/>
          </div>
          <div className="input">
            <input 
            onChange={e => setAdmissao(e.target.value)}
            type="number"
            placeholder="admição"/>
          </div>
        </div>
        <div className="row">
          <div className="input">
            <input 
            onChange={e => setSalario(e.target.value)}
            type="number"
            placeholder="salário"/>
          </div>
        </div>
        <button type="submit" className="cadastrar format btn">Cadastrar</button>
      </form>
      </div>
      
      <div className="card">
      <h1>Funcionários</h1>
      <div className="input">
        <input type="text"/>
        <button className="format" type="submit">BUSCAR</button>
      </div>

      <ul>

        {funcionarios.map(funcionario => (
        <li id="funcionarios">
          <div className="direita">
            <button onClick={() => handleDeletFuncionario(funcionario.id_Funcionario)} className="remover">
              <p>x</p>
            </button>
          </div>
          <div className="nomes"> 
            <h2 className="idFuncionario">#00{funcionario.id_Funcionario} -</h2>
            <h2 className="nomeDoFuncionario">{funcionario.nome}</h2>
            
          </div>
          ______________________________________________________________
          <div className="details">
            <p className="title">Documentos:</p>
            <div className="infos">
              
              <p><b>RG: </b> {funcionario.rg}</p>
              <p><b>CPF: </b> {funcionario.cpf}</p>
            </div>
            <p className="title">Endereço:</p>
            <div className="infos">
              <p><b>Rua: </b> {funcionario.rua}, {funcionario.numero}. {funcionario.bairro}</p>
              <p><b>Complemento: </b> {funcionario.complemento} <b>CEP: </b> {funcionario.cep}</p>
              <p><b>Cidade: </b> {funcionario.cidade} <b>UF: </b> {funcionario.uf} <b>Pais: </b> {funcionario.pais}</p>
            </div>
            <p className="title">Contato:</p>
            <div className="infos">
              <p><b>Telefone:</b> {funcionario.telefone} <b>Celular:</b> {funcionario.celular}</p> 
              <p><b>Email:</b> {funcionario.email}</p>
            </div>
            <div className="infos">
              <p><b>salario: </b>{funcionario.salario}  <b>admissão: </b>{funcionario.admissao}</p>
            </div>
            
            
          </div>
        </li>
        ))}
        
      </ul>

      </div>
    </div>
    <Footer />
    </>
  );
}

export default Funcionarios;
