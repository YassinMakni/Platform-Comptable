import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDocumentActualiteComponent } from './list-document-actualite.component';

describe('ListDocumentActualiteComponent', () => {
  let component: ListDocumentActualiteComponent;
  let fixture: ComponentFixture<ListDocumentActualiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDocumentActualiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDocumentActualiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
