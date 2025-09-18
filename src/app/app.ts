import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Menu } from './components/shared/menu/menu';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [
    RouterOutlet,
    Menu
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  private http = inject(HttpClient);

  ngOnInit(){
    this.http.get('http://localhost:8081/api/v1/produtos')
             .subscribe((dados) => console.table(dados));
  }
}
