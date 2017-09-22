import { Component } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Dribbble Java';
  private apiUrl = 'http://localhost:8080/dribbble';
  data: any = {};
  screenshot: any;

  constructor(private http: Http, private modalService: NgbModal) {
    console.log('Hello fellow user');
    this.getPopularScreenshots();
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
  
    return this.http.post(`${this.apiUrl}/addToFavorites`, this.screenshot, requestOptions).subscribe(data => {
      console.log(data['_body']);
    });
  }



  openModal(content, shot) {
    const modalRef = this.modalService.open(content);
    this.screenshot = shot;
  }



}
