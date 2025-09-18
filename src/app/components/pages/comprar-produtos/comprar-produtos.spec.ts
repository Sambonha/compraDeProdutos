import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComprarProdutos } from './comprar-produtos';

describe('ComprarProdutos', () => {
  let component: ComprarProdutos;
  let fixture: ComponentFixture<ComprarProdutos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComprarProdutos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComprarProdutos);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
