import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListNewsComponent } from './list-news.component';

describe('ListNewsComponent', () => {
  let component: ListNewsComponent;
  let fixture: ComponentFixture<ListNewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListNewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListNewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});