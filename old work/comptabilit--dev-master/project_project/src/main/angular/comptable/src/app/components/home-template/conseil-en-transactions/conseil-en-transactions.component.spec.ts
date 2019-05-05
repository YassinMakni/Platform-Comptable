import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConseilEnTransactionsComponent } from './conseil-en-transactions.component';

describe('ConseilEnTransactionsComponent', () => {
  let component: ConseilEnTransactionsComponent;
  let fixture: ComponentFixture<ConseilEnTransactionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConseilEnTransactionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConseilEnTransactionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
