import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';

//components
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
import { LoginformComponent } from './components/loginform/loginform.component';
import { RegisterformComponent } from './components/registerform/registerform.component';
import { ForumcomponentComponent } from './components/forumcomponent/forumcomponent.component';

//services
import { ForumService } from './services/forum.service';
import { UserService } from './services/user.service';

import { FormsModule }   from '@angular/forms';
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
    ForumlisterComponent,
    ForumcomponentComponent,
    RegisterformComponent,
    LoginformComponent,
  ],
  imports: [
    HttpModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [ForumService, UserService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
