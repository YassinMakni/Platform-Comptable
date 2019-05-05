import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SousListDocumentComponent } from './sous-list-document.component';

describe('SousListDocumentComponent', () => {
  let component: SousListDocumentComponent;
  let fixture: ComponentFixture<SousListDocumentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SousListDocumentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SousListDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
