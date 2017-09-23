import { Component } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import {ToastyService, ToastyConfig, ToastOptions, ToastData} from 'ng2-toasty';
import { Router } from '@angular/router';

import 'rxjs/add/operator/map';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent {

  title = 'Dribbble Java';
  private apiUrl = 'http://localhost:8080/dribbble';
  data: any = {};
  screenshot: any;

  constructor(private http: Http, private modalService: NgbModal,
              private toastyService:ToastyService, private toastyConfig: ToastyConfig, public router: Router) {
    this.getPopularScreenshots();
    this.toastyConfig.theme = 'default';
  }

  getData() {
    return this.http.get(`${this.apiUrl}/popular`)
      .map((res: Response) => res.json())
  }

  getPopularScreenshots(){
    this.getData().subscribe(data => {
      console.log(data);
      this.data = data;
    })
  }

  addToFavorite() {
    let requestOptions = new RequestOptions();
    requestOptions.headers = new Headers({"Content-Type":"application/json"});
  
    return this.http.post(`${this.apiUrl}/addToFavorites`, this.screenshot, requestOptions).subscribe(
      data => {
        let response = data.json();
        console.log(response)
        if (response.resultStatus === "SUCCESS") {
          this.showSuccess(response.message);
        } else {
          this.showWarn(response.message);          
        }
      },
      err => {    
        this.showError(err['_body']);
      });
  }

  openModal(content, shot) {
    const modalRef = this.modalService.open(content);
    this.screenshot = shot;
  }

  showSuccess(msg) {
    this.toastyService.success(msg);
  }

  showWarn(msg) {
    this.toastyService.warning(msg);
  }

  showError(msg) {
    this.toastyService.error(msg)
  }

}
