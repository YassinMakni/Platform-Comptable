import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListConventionsComponent } from './list-conventions.component';

describe('ListConventionsComponent', () => {
  let component: ListConventionsComponent;
  let fixture: ComponentFixture<ListConventionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListConventionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListConventionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
