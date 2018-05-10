import {Router, ActivatedRoute, Params} from '@angular/router';
import {OnInit, Component} from '@angular/core';
import { ForumService } from '../../services/forum.service';
import { Forum } from '../../models/Forum';
import { stringify } from 'querystring';
@Component({
  selector: 'app-forumcomponent',
  templateUrl: './forumcomponent.component.html',
  styleUrls: ['./forumcomponent.component.css']
})
export class ForumcomponentComponent implements OnInit {

  id: any;
  currentForum: Forum;
  constructor(private activatedRoute: ActivatedRoute, private router: Router, private forumService: ForumService) {
    this.currentForum = new Forum();
  }

  ngOnInit() {
  
    this.id = this.activatedRoute.snapshot.params['forumName'];
    
    this.forumService.getForumByName(this.id).subscribe(res => this.currentForum = res);
    console.log(stringify(this.currentForum));
   
  }

  addForumPost(title, description){
      this.forumService.addForumPost(title, description, this.currentForum.id);
  }
}
