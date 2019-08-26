import { Component, OnInit } from '@angular/core';
import { BuchService } from '../Services/buch.service';
import { Book } from '../Entity/Book';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-buch-detail',
  templateUrl: './buch-detail.component.html',
  styleUrls: ['./buch-detail.component.css']
})
export class BuchDetailComponent implements OnInit {

  

  constructor(private bookService: BuchService, private route: ActivatedRoute) { }
  book: Book;
  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('bookId');
    this.bookService.getBookByID(id).subscribe(book => (this.book = book));

  }

}
