import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/shared/post.service';
import { ActivatedRoute } from '@angular/router';
import { ResponseService } from 'src/app/response/response.service';
import { PostModel } from 'src/app/shared/post-model';
import { ResponsePayload } from 'src/app/response/response.payload';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  name: string;
  posts: PostModel[];
  responses: ResponsePayload[];
  postLength: number;
  responseLength: number;

  constructor(private activatedRoute: ActivatedRoute, private postService: PostService,
    private responseService: ResponseService) {
    this.name = this.activatedRoute.snapshot.params.name;

    this.postService.getAllPostsByUser(this.name).subscribe(data => {
      this.posts = data;
      this.postLength = data.length;
    });
    this.responseService.getAllResponsesByUser(this.name).subscribe(data => {
      this.responses = data;
      this.responseLength = data.length;
    });
  }

  ngOnInit(): void {
  }

}