import React from 'react';
import Login from './pages/Login/index';
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import Home from './pages/Home/index';
import Cadastro from './pages/Cadastro/index';
import Produtos from './pages/Products/index';
import Vendas from './pages/Vendas';
import Clientes from './pages/Clientes';
import Fornecedores from './pages/Fornecedores';
import Funcionarios from './pages/Funcionarios'

function Routes(){
    return(
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Login} />
                <Route path="/home" component={Home} />
                <Route path="/cadastro" component={Cadastro} />
                <Route path="/produtos" component={Produtos} />
                <Route path="/vendas" component={Vendas} />
                <Route path="/clientes" component={Clientes} />
                <Route path="/fornecedores" component={Fornecedores} />
                <Route path="/funcionarios" component={Funcionarios} />

            </Switch>
        </BrowserRouter>
    );
}

export default Routes;