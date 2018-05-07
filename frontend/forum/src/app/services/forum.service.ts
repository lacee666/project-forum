import { Injectable } from '@angular/core';
import { Forum } from '../models/Forum';


@Injectable()
export class ForumService {

  constructor() { }
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
}
