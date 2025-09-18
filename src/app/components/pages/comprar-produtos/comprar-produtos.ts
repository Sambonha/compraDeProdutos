import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject, signal } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-comprar-produtos',
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './comprar-produtos.html',
  styleUrl: './comprar-produtos.css'
})
export class ComprarProdutos {
  
  mensagem = signal<string>('');
  
  private http = inject(HttpClient)
 

    formulario = new FormGroup({
    nomeProduto : new FormControl('', [Validators.required]),
    precoProduto : new FormControl<number>(0, [Validators.required])
  });

  comprarProduto(){
    this.http.post('http://localhost:8081/api/v1/produtos',
      this.formulario.value, { responseType: 'text'})
    .subscribe((resposta)=> {
      this.mensagem.set(resposta);
      this.formulario.reset();
    });

  }
}
