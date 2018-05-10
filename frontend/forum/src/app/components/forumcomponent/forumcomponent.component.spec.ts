import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForumcomponentComponent } from './forumcomponent.component';

describe('ForumcomponentComponent', () => {
  let component: ForumcomponentComponent;
  let fixture: ComponentFixture<ForumcomponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForumcomponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForumcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
