import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, inject, signal } from '@angular/core';

@Component({
  selector: 'app-consultar-produtos',
  imports: [
    CommonModule
  ],
  templateUrl: './consultar-produtos.html',
  styleUrl: './consultar-produtos.css'
})
export class ConsultarProdutos {

  produtos = signal<any[]>([]);
  private http = inject(HttpClient);


  ngOnInit() {

    this.http.get('http://localhost:8081/api/v1/produtos')
      .subscribe((dados) => {
        this.produtos.set(dados as any[]);
      })
  }

  excluirTarefa(id: string) {
    if (confirm('Deseja realmente excluir este produto?')) {
      this.http.delete('http://localhost:8081/api/v1/produtos/' + id,
        { responseType: 'text' })
        .subscribe((resposta) => {
          alert(resposta);
          this.ngOnInit();
        });
    }
  }

  valorTotal(): number{
    return this.produtos().reduce((total, p) => total + p.preco, 0);
  }
}
