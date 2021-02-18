import React, { useState } from 'react';
import { Link } from 'react-router-dom'
//import api from '../services/api';
import './style.css';

import escritorio from '../../assets/escritorio.svg';
import email from '../../assets/email.svg';
import senha from '../../assets/senha.svg';
import Header from '../../components/Header';
import api from '../../services/api';

function Login(){

  const [ emailData, setEmail ] = useState('');
  const [ senhaData, setSenha ] = useState('');

  async function handleNewFuncionarios(e){
    e.preventDefault();

    const data = {
      emailData,
      senhaData,
    }
    try{
      await api.get('/login', data);
      //history.push('/funcionarios');
      console.log(data);
    }catch (err){
      alert('ERROR');
    }
  }

//const response = api.post('ROTA', {id});
//localStorage.setItem('propId', 1);// 1 é o valor estatico de Id do Proprietário "prop"


return(

  <div>
  <Header menu = {false}/>   
  <div id="container">
    <div id="left">
      <img src={escritorio} />
      <Link to = "/cadastro">
      <input 
        type="button" 
        value="CRIAR CONTA" 
        className="btn l"
      />
      </Link>
    </div>
    <div id="right">
      <form method = "get">
        <h1 className="blue-title">LOGIN</h1>
        <div className="input pb">
          <img src={email} />
          <input 
            type="email" 
            onChange={e => setEmail(e.target.value)}
            placeholder="E-mail"
          />
        </div>
        <div className="input">
          <img src={senha} />
          <input 
            type="password"
            onChange={e => setSenha(e.target.value)}
            placeholder="Senha"
          />
        </div>
        {/*<Link to = "/home">
        
</Link>*/}
        <input 
          onSubmit={handleNewFuncionarios}
          type="submit" 
          value="ENTRAR" 
          className="btn r"
        />
      </form>
    </div>
  </div>
</div>
  );
};

export default Login;