import { Routes } from '@angular/router';
import { ComprarProdutos } from './components/pages/comprar-produtos/comprar-produtos';
import { ConsultarProdutos } from './components/pages/consultar-produtos/consultar-produtos';
import { Dashboard } from './components/pages/dashboard/dashboard';

export const routes: Routes = [
   {
path: 'dashboard', /* criando a rota */
component: Dashboard /* página que a rota irá abrir */
},
{
path: 'comprar-produtos', /* criando a rota */
component: ComprarProdutos /* página que a rota irá abrir */
},
{
path: 'consultar-produtos', /* criando a rota */
component: ConsultarProdutos /* página que a rota irá abrir */
}
];
