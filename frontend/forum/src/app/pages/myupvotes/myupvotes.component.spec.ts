import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyupvotesComponent } from './myupvotes.component';

describe('MyupvotesComponent', () => {
  let component: MyupvotesComponent;
  let fixture: ComponentFixture<MyupvotesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyupvotesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyupvotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
