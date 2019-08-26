import { HttpClientModule} from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { BuchDetailComponent } from './buch-detail/buch-detail.component';
import { ReactiveFormsModule } from '@angular/forms'
import { from } from 'rxjs';

@NgModule({
  declarations: [AppComponent, BooksComponent, BuchDetailComponent],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
