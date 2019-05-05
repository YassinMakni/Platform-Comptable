import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDocumentConventionComponent } from './list-document-convention.component';

describe('ListDocumentConventionComponent', () => {
  let component: ListDocumentConventionComponent;
  let fixture: ComponentFixture<ListDocumentConventionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDocumentConventionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDocumentConventionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
