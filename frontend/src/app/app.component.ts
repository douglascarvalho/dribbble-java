import { Component } from '@angular/core';
import { Http, Response} from '@angular/http';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Dribbble Java';
  private apiUrl = 'http://localhost:8080/dribbble/popular';
  data: any = {};

  shotTitle: string;

  constructor(private http: Http, private modalService: NgbModal) {
    console.log('Hello fellow user');
    this.getPopularScreenshots();
    this.getData();
  }

  getData() {
    return this.http.get(this.apiUrl)
      .map((res: Response) => res.json())
  }

  getPopularScreenshots(){
    this.getData().subscribe(data => {
      console.log(data);
      this.data = data;
    })
  }

  openModal(content, shot) {
    const modalRef = this.modalService.open(content);
    this.shotTitle = shot.title;

  }


}
