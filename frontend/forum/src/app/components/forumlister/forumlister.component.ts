import { Component, OnInit } from '@angular/core';
import { Forum } from '../../models/Forum';
import { ForumService } from '../../services/forum.service';

@Component({
  selector: 'app-forumlister',
  templateUrl: './forumlister.component.html',
  styleUrls: ['./forumlister.component.css']
})
export class ForumlisterComponent implements OnInit {
  forumList: Array<Forum>;
  constructor(private forumService: ForumService) { }

  ngOnInit() {
    this.forumList = this.forumService.getAllForums();
    console.log(this.forumList);
    ;
    
  }

}
