import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// COMPONENTS
import {IndexComponent} from './pages/index/index.component';
import {LoginComponent} from './pages/login/login.component';
import {ContactComponent} from './pages/contact/contact.component';
import {MycommentsComponent} from './pages/mycomments/mycomments.component';
import {MydownvotesComponent} from './pages/mydownvotes/mydownvotes.component';
import {MyupvotesComponent} from './pages/myupvotes/myupvotes.component';
import {MyforumsComponent} from './pages/myforums/myforums.component';
import {MythreadsComponent} from './pages/mythreads/mythreads.component';
import {ProfileComponent} from './pages/profile/profile.component';
import {SubscribedforumsComponent} from './pages/subscribedforums/subscribedforums.component';

const routes: Routes = [
  { path: '', component: IndexComponent},
  { path: 'login', component: LoginComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'mycomments',  component: MycommentsComponent},
  { path: 'mydownvotes',  component: MydownvotesComponent},
  { path: 'myupvotes',  component: MyupvotesComponent},
  { path: 'myforums',  component: MyforumsComponent},
  { path: 'mythreads',  component: MythreadsComponent},
  { path: 'profile',  component: ProfileComponent},
  { path: 'subscribedforums',  component: SubscribedforumsComponent},
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  declarations: [],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
