import { Component, OnInit } from '@angular/core';
import { Forum } from '../../models/Forum';
import { ForumService } from '../../services/forum.service';
import {Router, ActivatedRoute, Params, NavigationExtras} from '@angular/router';
@Component({
  selector: 'app-forumlister',
  templateUrl: './forumlister.component.html',
  styleUrls: ['./forumlister.component.css']
})
export class ForumlisterComponent implements OnInit {
  forumList: Array<Forum>;
  constructor(private forumService: ForumService, private router: Router) { }

  ngOnInit() {

    this.forumService.getAllForums().subscribe(res => this.forumList = res);
    console.log(this.forumList);
    ;
    
  }
  onSelect(forum){
    this.router.navigate(['/forum', forum.forumName])
  }
}
