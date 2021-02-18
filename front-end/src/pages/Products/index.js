import React, { useEffect, useState } from 'react';
import Header from '../../components/Header';
import Footer from '../../components/Footer';
import { useHistory } from 'react-router-dom';

import api from '../../services/api';

import '../../global.css';
import './styles.css';

function Products(){

  /**
   * variaveis de estado do metodo GET
   */

  const [nome, setNome] = useState('');
  const [precoCusto, setPrecoCusto] = useState();
  const [precoVenda, setPrecoVenda] = useState();
  const [categoria, setCategoria] = useState();
  const [marca, setMarca] = useState('');
  const [lote, setLote] = useState();
  const [origem, setOrigem] = useState('')
  const [altura, setAltura] = useState();
  const [largura, setLargura] = useState();
  const [comprimento, setComprimento] = useState();
  const [peso, setPeso] = useState();
  const [validade, setValidade] = useState('');
  const [idFornecedor, setIdFornecedor] = useState();
  
  //variaveis
  const history = useHistory();
  /**
   * variaveis de estado do metodo POST
   */
  const [products, setProducts] = useState([])

async function handleNewProduct(e){
  e.preventDefault();

  const resp = {
    nome: nome,
    preco_Custo: precoCusto,
    preco_Venda: precoVenda,
    categoria: categoria,
    marca: marca,
    lote: lote,
    origem: origem,
    altura: altura,
    largura: largura,
    comprimento: comprimento,
    peso: peso,
    validade: validade,
    id_FornecedorP: idFornecedor,
  };
  try{
    await api.post('/produtos', resp);
    history.push('/produtos');
    console.log(resp);
  }catch (err){
    alert('ERROR');
  }
}

useEffect(() => {
  api.get('/produtos').then(response => {
    setProducts(response.data)
  })
})

async function handleDeletIncident(id) {
  try{
      await api.delete(`/produtos/${id}`);

      setProducts(products.filter(product => product.id_Produto !== id));
  }catch{alert('erro ao deletar produto');}
}

return(
<>
  <Header menu = {true}/>
  <div id="principal">
    <div className="card">
      <h1>Cadastrar produtos</h1>
      <form onSubmit={handleNewProduct}>
        <div className="row">
          <div className="input">
            <input 
            type="text"
            name="nome"
            placeholder = "Nome"
            onChange={e => setNome(e.target.value)}/>
          </div>
          <div className="input">
            <input
            type="text"
            name="categoria"
            placeholder = "categoria"
            onChange={e => setCategoria(e.target.value)}/>
          </div>
        </div>

        <div className="row">
          <div className="input">
            <input 
            type="number"
            step="any" 
            name="precoCusto"
            placeholder = "Valor de custo"
            onChange={e => setPrecoCusto(e.target.value)}/>
          </div>
          <div className="input">
            <input 
            type="number" 
            step="any"
            name="precoVenda"
            placeholder = "Valor de venda"
            onChange={e => setPrecoVenda(e.target.value)}/>
          </div>
        </div>

        <div className="row">
          <div className="input">
            <input 
            type="text"
            name="marca" 
            placeholder = "Marca"
            onChange={e => setMarca(e.target.value)}/>
          </div>
          <div className="input">
            <input 
            type="number"
            step="any"
            name="lote" 
            placeholder = "Lote"
            onChange={e => setLote(e.target.value)}/>
          </div>
        </div>

        <div className="row">
          <div className="input">
            <input 
            type="text"
            name="origem" 
            placeholder = "Origem"
            onChange={e => setOrigem(e.target.value)}/>
          </div>
          <div className="input">
            <input 
            type="number" 
            step="any"
            name="altura"
            placeholder = "altura"
            onChange={e => setAltura(e.target.value)}/>
          </div>
        </div>

        <div className="row">
          <div className="input">
            <input 
            type="number" 
            step="any"
            name="largura"
            placeholder = "Largura"
            onChange={e => setLargura(e.target.value)}/>
          </div>
          <div className="input">
            <input 
            type="number" 
            step="any"
            name="comprimento"
            placeholder = "Comprimento"
            onChange={e => setComprimento(e.target.value)}/>
          </div>
        </div>

        <div className="row">
          <div className="input">
            <input 
            type="number" 
            step="any"
            name="peso"
            placeholder = "peso"
            onChange={e => setPeso(e.target.value)}/>
          </div>
          <div className="input">
            <input 
            type="text"
            name="validade" 
            placeholder = "validade"
            onChange={e => setValidade(e.target.value)}/>
          </div>
        </div>
        
        <div className="input">
          <input 
          type="number" 
          step="any"
          name="idFornecedor"
          placeholder = "Id do fornecedor"
          onChange={e => setIdFornecedor(e.target.value)}/>
        </div>
        <button type = "submit" className="cadastrar format btn">Cadastrar</button>
      </form>
      _________________________________________________________________________
      <br/><br/>
      <h1>Buscar produto</h1>
      <div className="input">
        <input type="text"/>
        <button className="format" type="submit">BUSCAR</button>
      </div>

      <br/>

      <ul className="column">

        {products.map(product => (
          <li id="product">
            <h2 className="nomeDoProduto">#0{product.id_Produto} - {product.nome}</h2>
            <div className="containerPreco">
              <span className="precoDoProdutoVenda">R$ {product.preco_Venda}</span>
              <button className="remover" onClick={() => handleDeletIncident(product.id_Produto)}>
              <p>x</p>
              </button>
            </div>
          </li>
        ))}

      </ul>
        </div>
        
      </div>{/*#main*/}
      <Footer />
    </>
);
};

export default Products;