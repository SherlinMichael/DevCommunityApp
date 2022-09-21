import { Component, OnInit } from '@angular/core';
import { PostService } from 'src/app/shared/post.service';
import { ActivatedRoute, Router } from '@angular/router';
import { PostModel } from 'src/app/shared/post-model';
import { throwError } from 'rxjs';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ResponsePayload } from 'src/app/response/response.payload';
import { ResponseService } from 'src/app/response/response.service';

@Component({
  selector: 'app-view-post',
  templateUrl: './view-post.component.html',
  styleUrls: ['./view-post.component.css']
})
export class ViewPostComponent implements OnInit {

  postId: number;
  post: PostModel;
  responseForm: FormGroup;
  responsePayload: ResponsePayload;
  responses: ResponsePayload[];

  constructor(private postService: PostService, private activateRoute: ActivatedRoute,
    private responseService: ResponseService, private router: Router) {
    this.postId = this.activateRoute.snapshot.params.id;

    this.responseForm = new FormGroup({
      text: new FormControl('', Validators.required)
    });
    this.responsePayload = {
      text: '',
      postId: this.postId
    };
  }

  ngOnInit(): void {
    this.getPostById();
    this.getResponsesForPost();
  }

  postResponse() {
    this.responsePayload.text = this.responseForm.get('text').value;
    this.responseService.postResponse(this.ResponsePayload).subscribe(data => {
      this.responseForm.get('text').setValue('');
      this.getResponsesForPost();
    }, error => {
      throwError(error);
    })
  }

  private getPostById() {
    this.postService.getPost(this.postId).subscribe(data => {
      this.post = data;
    }, error => {
      throwError(error);
    });
  }

  private getResponsesForPost() {
    this.responseService.getAllResponsesForPost(this.postId).subscribe(data => {
      this.responses = data;
    }, error => {
      throwError(error);
    });
  }

}