import { Injectable } from '@angular/core';
import { Forum } from '../models/Forum';
import { Http, Response, Jsonp, Headers } from '@angular/http';
import {User} from '../models/User';
import {Observable} from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import {Router} from '@angular/router';


@Injectable()
export class ForumService {
  private url: string = "/api/f";

  constructor(private http: Http, private router: Router) { 
  }
/*
  getAllForums(): Array<Forum>{
    try{
      let forum: Forum = new Forum();
      forum.title="az elso cime";
      forum.text="ez az elso szovege";
      forum.admin="Sanyi";
  
      let forum2: Forum = new Forum();
      forum2.title="az masodik cime";
      forum2.text="ez a masodik szovege";
      forum2.admin="Bela";
  
      let forumList: Array<Forum> = new Array<Forum>();
  
      forumList[0] = forum;
      forumList[1] = forum2;
  
      return forumList;
    }catch(error){
      console.log(error);
    }
    
  }
*/
  getAllForums(): Observable<Array<Forum>>{
    return this.http.get(this.url + '/all').map((res => res.json()));
  }
  getForumByName(forumName): Observable<Forum>{
    return this.http.get(this.url + '/'+ forumName).map(res => res.json());
  }
}
