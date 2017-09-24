import { Component } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { ToastyService, ToastyConfig, ToastOptions, ToastData } from 'ng2-toasty';
import { Router } from '@angular/router';

import 'rxjs/add/operator/map';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent {

  data: any = {};
  screenshot: any;

  constructor(private http: Http, private modalService: NgbModal,
              private toastyService:ToastyService, private toastyConfig: ToastyConfig, public router: Router) {
    this.getPopularScreenshots();
    this.toastyConfig.theme = 'default';
  }

  getData() {
    return this.http.get(`${environment.apiUrl}/popular`)
      .map((res: Response) => res.json())
  }

  getPopularScreenshots(){
    this.getData().subscribe(data => {
      console.log(data);
      this.data = data;
    })
  }

}
