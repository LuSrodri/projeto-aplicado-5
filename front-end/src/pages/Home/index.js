import React, { useEffect, useState } from 'react';
import {Link} from 'react-router-dom';

import api from '../../services/api'

import perfil from '../../assets/name.svg';
import Chart from '../../components/Chart/chart';
import Header from '../../components/Header/';
import Footer from '../../components/Footer';

import './style.css';

function Home(){

  // const [proprietarios, setProprietarios] = useState([]);
  const [produtos, setProdutos] = useState([]);
  
  // let idLogado = localStorage.getItem('propId');

  // useEffect(() => {
  //   api.get('/proprietarios').then(response => {
  //     setProprietarios(response.data)
  //   })
  // });
  useEffect(() => {
    api.get('/produtos').then(response => {
      setProdutos(response.data)
    })
  });

  return(
    <>
      <Header menu = {true}/>
      <div id="main">
        <div className="content grid-template-area">
        <div className="header item">
            <div className="marginr">
              {// <h1>prop.id_Proprietario</h1>
              }
              <b>proprietário:</b> Fulano <br/>
              <b>cpf:</b> 000.000.000-00 <br/>
              <b>rg:</b> 00.000.000-0<br/>
              <b>cnpj:</b> 00.000.000/0000-00<br/>
              <b>IE:</b> numero<br/>
              <b>razão social:</b> nome<br/>
              <b>ramo/atividade:</b> atividade<br/>
              <b>nomefantasia:</b> nome<br/>
              <b>porte:</b> p m g<br/>
              <b>cnae:</b> numero eu acho<br/>
              <b>filial:</b> numero<br/>
              <b></b>
            </div>
            <div>
              <b>Endereço:</b>rua dois, 15 jd. tulipas <br/>
              <b>complemento:</b> empresa<br/>
              <b>cep:</b> 000.000-00<br/>
              <b>cidade:</b> Sorocity<br/>
              <b>uf:</b> São Paulo<br/>
              <b>pais:</b> Brasil<br/>
              <b>telefone:</b> +55 (15) 3329-9908<br/>
              <b>celular:</b> +55 (15) 9 9157-6557<br/>
              <b>email:</b> fulano@facens.br<br/>
            </div>
            
          </div>


          <div className="header2 item">
            <div className="product ">
              <Link to="/clientes">Clientes</Link>
            </div>
            <div className="product">
              <Link to="/funcionarios">Funcionários</Link>
            </div>
            <div className="product">
              <Link to="/fornecedores">Fornecedores</Link>
            </div>

          </div>

          <div className="info item">
            <div className="head">
              <img className="perfil" src={perfil}/>
              <div className="description">
                <h1 className="name">casa dos vasos</h1>
                <p className="detail">Vasos e decorações</p>
              </div>
            </div>

              Produtos:
              <ul className="prodContainer">
              {produtos.map(produto => (
              <li id="product">
                <h2 className="nomeDoProduto">#0{produto.id_Produto} - Vaso de cimento</h2>
                <div className="containerPreco">
                  <span className="precoDoProdutoVenda">R$ {produto.preco_Venda}</span>
                </div>
              </li>
              ))}
              </ul>
              <li className="product">
              <Link to="/produtos">Ver todos</Link>
              </li>
          </div>
          <div className="grafic item">
            <h1>Resumo de vendas</h1>
            <Chart />
            <Link to="/vendas">Ver mais detalhes</Link>
          </div>
          <div className="sells item">
            <h1>vendas</h1>
            <ul className="lista">
              <li className="product">
                <Link to="/vendas">vendas</Link>
              </li>
            </ul>
          </div>
        </div>
        <Footer/>
        
      </div>
    </>
    );
};

export default Home;