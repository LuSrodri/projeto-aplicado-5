import React, { useEffect, useState } from 'react';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import { useHistory } from 'react-router-dom';

import api from '../../services/api';

import '../../global.css';
import './styles.css';

function Clientes() {

  const [clients, setClients] = useState([]);
  
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

  const history = useHistory();

  async function handleNewClient(e){
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
    };
    try{
      await api.post('/clientes', data);
      history.push('/clientes');
      console.log(data);
    }catch (err){
      alert('ERROR');
    }
  }

  useEffect(() => {
    api.get('/clientes').then(response => {
      setClients(response.data)
    })
  })

  async function handleDeletCliente(id) {
    try{
        await api.delete(`/clientes/${id}`);
  
        setClients(clients.filter(client => client.id_Cliente !== id));
    }catch{
      alert('erro ao deletar otário');
    }
  }


  

  return(
    <>
    <Header menu = {true}/>
    <div id="principal">
      <div className="card">
      <form onSubmit={handleNewClient}>
        <h1>Cadastro de clientes</h1>
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
        </div>
        <button type="submit" className="cadastrar format btn">Cadastrar</button>
      </form>
      </div>
      
      <div className="card">
      <h1>Clientes</h1>
      <div className="input">
        <input type="text"/>
        <button className="format" type="submit">BUSCAR</button>
      </div>

      <ul>

        {clients.map(client => (
        <li id="clients">
          <div className="nomes"> 
            <h2 className="idCliente">#00{client.id_Cliente} -</h2>
            <h2 className="nomeDoCliente">{client.nome}</h2>
            
          </div>
          ______________________________________________________________
          <div className="details">
            <p className="title">Documentos:</p>
            <div className="documents">
              
              <p><b>RG: </b> {client.rg}</p>
              <p><b>CPF: </b> {client.cpf}</p>
            </div>
            <p className="title">Endereço:</p>
            <div className="adress">
              <p><b>Rua: </b> {client.rua}, {client.numero}. {client.bairro}</p>
              <p><b>Complemento: </b> {client.complemento} <b>CEP: </b> {client.cep}</p>
              <p><b>Cidade: </b> {client.cidade} <b>UF: </b> {client.uf} <b>Pais: </b> {client.pais}</p>
            </div>
            <p className="title">Contato:</p>
            <div className="contact">
              <p><b>Telefone:</b> {client.telefone} <b>Celular:</b> {client.celular}</p> 
              <p><b>Email:</b> {client.email}</p>
            </div>
            <div className="direita">
              <button onClick={() => handleDeletCliente(client.id_Cliente)} className="remover">
              <p>x</p>
            </button>
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

export default Clientes;
