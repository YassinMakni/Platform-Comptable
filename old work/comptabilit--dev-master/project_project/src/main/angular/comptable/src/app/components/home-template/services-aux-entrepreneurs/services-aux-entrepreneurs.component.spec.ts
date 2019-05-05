import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServicesAuxEntrepreneursComponent } from './services-aux-entrepreneurs.component';

describe('ServicesAuxEntrepreneursComponent', () => {
  let component: ServicesAuxEntrepreneursComponent;
  let fixture: ComponentFixture<ServicesAuxEntrepreneursComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServicesAuxEntrepreneursComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServicesAuxEntrepreneursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
