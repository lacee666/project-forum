import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { IndexComponent } from './pages/index/index.component';
import { FooterComponent } from './components/footer/footer.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { ContactComponent } from './pages/contact/contact.component';
import { MyforumsComponent } from './pages/myforums/myforums.component';
import { MycommentsComponent } from './pages/mycomments/mycomments.component';
import { MythreadsComponent } from './pages/mythreads/mythreads.component';
import { MyupvotesComponent } from './pages/myupvotes/myupvotes.component';
import { MydownvotesComponent } from './pages/mydownvotes/mydownvotes.component';
import { SubscribedforumsComponent } from './pages/subscribedforums/subscribedforums.component';
import { ForumlisterComponent } from './components/forumlister/forumlister.component';
import { ForumService } from './services/forum.service';


import { HttpModule } from '@angular/http';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    IndexComponent,
    FooterComponent,
    LoginComponent,
    ProfileComponent,
    ContactComponent,
    MyforumsComponent,
    MycommentsComponent,
    MythreadsComponent,
    MyupvotesComponent,
    MydownvotesComponent,
    SubscribedforumsComponent,
    ForumlisterComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    AppRoutingModule
  ],
  providers: [ForumService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
