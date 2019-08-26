import { Component, OnInit } from '@angular/core';
import { BuchService } from '../Services/buch.service';
import { Book } from '../Entity/Book';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  title = 'myLibrary';
  bookForm: FormGroup;
  isCreating: boolean = false;

  bookList: Book[];

  constructor(private bookService: BuchService, private fb: FormBuilder) { }

  ngOnInit() {
    this.bookService.getAllBooks().subscribe(books => this.bookList = books);
    this.bookForm = this.fb.group({
      title: ["", Validators.required],
      price: ["", Validators.required],
      published: ["", Validators.required],
    });
  }

  deleteBookById(id: number) {
    this.bookService.deleteBookByID(id).subscribe(id => (this.bookList = this.bookList.filter(bookEntry => bookEntry.id != id)));
  }
  
  createBook() {
    const book: Book = this.bookForm.value;
    book.id = null;
    this.bookService.createBook(book).subscribe(book => this.bookList.push(book));
    this.isCreating = false;
  }

  openForm() {
    this.isCreating = true;
  }
}
