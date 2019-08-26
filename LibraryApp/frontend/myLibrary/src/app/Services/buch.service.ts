import { Injectable } from '@angular/core';
import { Book } from '../Entity/Book';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class BuchService {
  bookList: Book[] = [];

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<Book[]> {
    return this.http.get<Book[]>('http://localhost:8080/book');
  }

  getBookByID(id: number): Observable<Book> {
    return this.http.get<Book>('http://localhost:8080/book/' + id);
  }

  deleteBookByID(id: number): Observable<number> {
    return this.http.delete<number>('http://localhost:8080/book/' + id);
  }

  createBook(book: Book): Observable<Book> {
    const httpOptions = {
      headers: new HttpHeaders({'Content-Type': 'application/json'})}
    return this.http.post<Book>('http://localhost:8080/book/', book, httpOptions);
  }
}
