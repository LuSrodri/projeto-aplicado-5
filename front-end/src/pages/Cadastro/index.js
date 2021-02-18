import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';
import api from '../../services/api';

import Footer from '../../components/Footer';

import './style.css';

import emailImg from '../../assets/email.svg';
import nomeImg from '../../assets/name.svg';
import senhaImg from '../../assets/senha.svg';
import paisImg from '../../assets/pais.svg';
import ruaImg from '../../assets/mapa-da-cidade.svg';
import documentoImg from '../../assets/documento.svg';
import foneImg from '../../assets/apoio.svg';
import empresaImg from '../../assets/companhia.svg';
import Header from '../../components/Header';

function Cadastro(){
  
  const [nome, setNome] = useState('');
  const [CPF, setCPF] = useState('');
  const [RG, setRG] = useState('');
  const [CNPJ, setCNPJ] = useState('');
  const [IE, setIE] = useState('');
  const [razaoSocial, setRazaoSocial] = useState('');
  const [ramoAtividade, setRamoAtividade] = useState('');
  const [nomeFantasia, setNomeFantasia] = useState('');
  const [rua, setRua] = useState('');
  const [numero, setNumero] = useState();
  const [bairro, setBairro] = useState('');
  const [complemento, setComplemento] = useState('');
  const [CEP, setCEP] = useState('');
  const [cidade, setCidade] = useState('');
  const [uf, setUf] = useState('');
  const [pais, setPais] = useState('');
  const [telefone, setTelefone] = useState('');
  const [celular, setCelular] = useState('');
  const [email, setEmail] = useState('');
  const [porte, setPorte] = useState('');
  const [CNAE, setCNAE] = useState('');
  const [filial, setFilial] = useState();
  //const [senha, setSenha] = useState('');
  //const [senha2, setSenha2] = useState('');

  const history = useHistory();

  async function handleNewIncident(e){
    e.preventDefault();

    const data = {
      nome: nome,
      cpf: CPF,
      rg: RG,
      cnpj: CNPJ,
      ie: IE,
      razão_Social: razaoSocial,
      ramo_Atividade: ramoAtividade,
      nome_Fantasia: nomeFantasia,
      rua: rua,
      número: numero,
      bairro: bairro,
      complemento: complemento,
      cep: CEP,
      cidade: cidade,
      uf: uf,
      pais: pais,
      telefone: telefone,
      celular: celular,
      email: email,
      porte: porte,
      cnae: CNAE,
      filial: filial,
      //senha,
      //senha2
    };
    try{
        await api.post('/proprietarios', data);
        history.push('/login');
        console.log(data);
    }catch (err){
        alert('ERROR');
    }
}

  return(
    <>
      <Header menu = {false}/>
      <div id="principal">
        <div className="card">
        <h1 className="blue-title">Cadastrar</h1>
        <form onSubmit={handleNewIncident}>
          <div className="row">
            
            <div className="input">{/*nome*/}
              <img src={nomeImg} alt = "nome" />
              <input 
                type="text" 
                name="name" 
                placeholder="Nome" 
                onChange={e => setNome(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*email*/}
              <img src={emailImg} alt = "email" />
              <input 
                type="email" 
                name="email" 
                placeholder="E-mail"
                onChange={e => setEmail(e.target.value)}
              />
            </div>{/*.input*/}

          </div>

          <div className="row">
            <div className="input">{/*CPF*/}
              <img src={documentoImg} alt = "CPF" />
              <input 
                type="text" 
                name="CPF" 
                placeholder="CPF" 
                onChange={e => setCPF(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*RG*/}
              <img src={documentoImg} alt = "RG" />
              <input 
                type="text" 
                name="RG" 
                placeholder="RG" 
                onChange={e => setRG(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*cnpj*/}
              <img src={documentoImg} alt = "img" />
              <input 
                type="text" 
                name="IE"
                placeholder="IE"
                onChange={e => setIE(e.target.value)}
              />
            </div>{/*.input*/}
          </div> {/*.row*/}

          <div className="row">
            <div className="input">{/*cnpj*/}
              <img src={documentoImg} alt = "CNPJ" />
              <input 
                type="text" 
                name="cnpj"
                placeholder="CNPJ"
                onChange={e => setCNPJ(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*cnae*/}
              <img src={documentoImg} alt = "CNAE" />
              <input 
                type="text" 
                name="cnae" 
                placeholder="CNAE"
                onChange={e => setCNAE(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*Razãoo social*/}
              <img src={documentoImg} alt = "Razão social"/>
              <input 
                type="text" 
                name="razao-social"
                placeholder="Razão social"
                onChange={e => setRazaoSocial(e.target.value)}
              />
            </div>{/*.input*/}
          </div>

          <div className="row">
            <div className="input">{/*Ramo/Atividade*/}
              <img src={empresaImg} alt = "Ramo/Atividade"/>
              <input 
                type="text" 
                name="ramo-atividade"
                placeholder="Ramo/Atividade"
                onChange={e => setRamoAtividade(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*nome fantasia*/}
              <img src={empresaImg} alt = "Nome fantasia"/>
              <input 
                type="text" 
                name="nome-fantasia"
                placeholder="Nome fantasia"
                onChange={e => setNomeFantasia(e.target.value)}
              />
            </div>{/*.input*/}
          </div>

          <div className="row">
          <div className="input">{/*porte*/}
              <img src={empresaImg} alt = "porte"/>
              <input 
                type="text" 
                name="porte" 
                placeholder="Pequena media ou grande"
                onChange={e => setPorte(e.target.value)}
              />
            </div>{/*.input*/}


            <div className="input">{/*filial*/}
              <img src={empresaImg} alt = "Filial"/>
              <input 
                type="number" 
                name="filial" 
                placeholder="Filial"
                onChange={e => setFilial(e.target.value)}
              />
            </div>{/*.input*/}
          
          </div>{/*.row*/}

          <div className="row">
            <div className="rua">{/*rua*/}
              <div className="input">{/*nome da rua*/}
                <img src={ruaImg} alt = "Logradouro"/>
                <input 
                  type="text" 
                  name="logradouro"
                  placeholder="Logradouro"
                  onChange={e => setRua(e.target.value)}
                />
              </div>{/*.input*/}
              <input 
                type="number" 
                name="number"
                placeholder="nº"
                onChange={e => setNumero(e.target.value)}
              />
            </div>{/*.rua*/}

            <div className="input">{/*bairro*/}
              <img src={ruaImg} alt = "bairro"/>
              <input 
                type="text" 
                name="bairro"
                placeholder="bairro"
                onChange={e => setBairro(e.target.value)}
              />
            </div>{/*.input*/}
          </div>

          <div className="row">
            <div className="input">{/*complemento*/}
              <img src={ruaImg} alt = "complemento"/>
              <input 
                type="text" 
                name="complemento"
                placeholder="complemento"
                onChange={e => setComplemento(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*CEP*/}
              <img src={ruaImg} alt = "cep"/>
              <input 
                type="text" 
                name="CEP"
                placeholder="CEP"
                onChange={e => setCEP(e.target.value)}
              />
            </div>{/*.input*/}
          </div>

          <div className="row">
            <div className="input">{/*cidade*/}
              <img src={paisImg} alt = "cidade"/>
              <input 
                type="text" 
                name="cidade"
                placeholder="Cidade"
                onChange={e => setCidade(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*UF*/}
              <img src={paisImg} alt = "uf"/>
              <input 
                type="text" 
                name="UF"
                placeholder="UF"
                onChange={e => setUf(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*pais*/}
              <img src={paisImg} alt = "País"/>
              <input 
                type="text" 
                name="pais"
                placeholder="País"
                onChange={e => setPais(e.target.value)}
              />
            </div>{/*.input*/}
          </div>

          <div className="row">
            <div className="input">{/*fone*/}
              <img src={foneImg} alt = "Telefone"/>
              <input 
                type="text" 
                name="fone" 
                placeholder="Telefone"
                onChange={e => setTelefone(e.target.value)}
              />
            </div>{/*.input*/}

            <div className="input">{/*celular*/}
              <img src={foneImg} alt = "Celular"/>
              <input 
                type="text" 
                name="celular" 
                placeholder="Celular"
                onChange={e => setCelular(e.target.value)}
              />
            </div>{/*.input*/}
          </div>

          <div className="row">
            <div className="input">{/*senha*/}
              <img src={senhaImg} alt = "Senha"/>
              <input 
                type="password" 
                name="senha"
                placeholder="Senha"
                
              />
            </div>{/*.input*/}
            <div className="input">{/*confirmar senha*/}
              <img src={senhaImg} alt = "confirmar-senha"/>
              <input 
                type="password" 
                name="confirmar-senha"
                placeholder="Confirmar senha"

              />
            </div>{/*.input*/}
          </div>{/*row*/}
        
          <input type="submit" value="CADASTRAR" className="btn r"/>
        </form>
        </div>{/*.card*/}
        
      </div>{/*#container*/}
      <Footer />
    </>
);
};

export default Cadastro;