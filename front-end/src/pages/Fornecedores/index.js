import React, { useEffect, useState } from 'react';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import { useHistory } from 'react-router-dom';

import api from '../../services/api';

import '../../global.css';
import './styles.css';

function Fornecedores () {
  
  const [fornecedores, setFornecedores] = useState([]);

  const [nome, setNome] = useState('');
  const [cnpj, setCNPJ] = useState('');

  const [razao_social, setRasaoSocial] = useState('');
  const [ramo_atividade, setRamoAtividade] = useState('');

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

  const history = useHistory();

  async function handleNewFornecedor(e){
    const data = {
      nome: nome,
      cnpj: cnpj,
      razao_social: razao_social,
      ramo_atividade: ramo_atividade,
      
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
    };
    try{
      await api.post('/fornecedores', data);
      history.push('/fornecedores');
      console.log(data);
    }catch (err){
      alert('ERROR');
    }
  }

  useEffect(() => {
    api.get('/fornecedores').then(response => {
      setFornecedores(response.data)
    })
  })

  async function handleDeletFornecedor(id) {
    try{
        await api.delete(`/fornecedores/${id}`);
  
        setFornecedores(fornecedores.filter(fornecedor => fornecedor.id_Fornecedor !== id));
    }catch{
      alert('erro ao deletar');
    }
  }

  return(
    <>
    <Header menu = {true}/>
    <div id="principal">
      <div className="card">
        <form onSubmit={handleNewFornecedor}>
        <h1>Cadastro de Fornecedores</h1>
        <h2>Dados do cliente:</h2>
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
            onChange={e => setCNPJ(e.target.value)}
            placeholder="CNPJ"/>
          </div>
        </div>

        <div className="row">
          <div className="input">
            <input 
            onChange={e => setRasaoSocial(e.target.value)}
            type="text"
            placeholder="Razão Social"/>
          </div>
          <div className="input">
            <input 
            onChange={e => setRamoAtividade(e.target.value)}
            type="text"
            placeholder="Ramo/Atividade"/>
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
        </div>
        <button type="submit" className="cadastrar format btn">Cadastrar</button>
        </form>
      </div>
      <div className="card">
      <h1>Fornecedores:</h1>
      <div className="input">
        <input type="text"/>
        <button className="format" type="submit">BUSCAR</button>
      </div>

      <ul>

      {fornecedores.map(fornecedor => (
        <li id="fornecedores">
          <div className="direita">
            <button onClick={() => handleDeletFornecedor(fornecedor.id_Fornecedor)} className="remover">
              <p>x</p>
            </button>
          </div>
          <div className="nomes"> 
            <h2 className="idFornecedor">#00{fornecedor.id_Fornecedor} -</h2>
            <h2 className="nomeDoFornecedor">{fornecedor.nome}</h2>

          </div>
          ______________________________________________________________
          <div className="details">
            <p className="title">Documentos:</p>
            <div className="infos">
              <p><b>Razão social: </b> {fornecedor.razao_Social}</p>
              <p><b>Ramo/Atividade: </b> {fornecedor.ramo_Atividade}</p>
              <p><b>CNPJ: </b> {fornecedor.cnpj}</p>
            </div>
            <p className="title">Endereço:</p>
            <div className="infos">
              <p><b>Rua: </b> {fornecedor.rua}, {fornecedor.numero}. {fornecedor.bairro}</p>
              <p><b>Complemento: </b> {fornecedor.complemento} <b>CEP: </b> {fornecedor.cep}</p>
              <p><b>Cidade: </b> {fornecedor.cidade} <b>UF: </b> {fornecedor.uf} <b>Pais: </b> {fornecedor.pais}</p>
            </div>
            <p className="title">Contato:</p>
            <div className="infos">
              <p><b>Telefone:</b> {fornecedor.telefone} <b>Celular:</b> {fornecedor.celular}</p> 
              <p><b>Email:</b> {fornecedor.email}</p>
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

export default Fornecedores;

  // ID_Fornecedor,
  // Nome 
  // CNPJ
  // Razão_Social
  // Ramo_Atividade 
  // Rua 
  // Número
  // Bairro 
  // Complemento
  // CEP
  // Cidade
  // UF
  // Pais
  // Telefone
  // Celular
  // Email