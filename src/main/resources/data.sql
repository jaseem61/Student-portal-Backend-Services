insert into teacher (id, name, password)
values (10001,'jaseem', 'abc123');
insert into teacher (id, name, password)
values (10002,'nazim', 'abc123');
insert into teacher (id, name, password)
values (10003,'azeem', 'abc123');

insert into course (id, name, teacher_id)
values (20001,'Physics',10001);
insert into course (id, name, teacher_id)
values (20002,'Maths',10002);
insert into course (id, name, teacher_id)
values (20003,'Chemistry',10003);

insert into assignment (id, name, course_id, description)
values (40001,'Create a Theory in Physics',20001,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer luctus egestas tempo Aliquam quis nunc nec leo pulvinar laoreet ac a augue. Nam sagittis ipsum non tempor ultricies. Morbi laoreet ante in justo varius congue. Aenean ornare varius');
insert into assignment (id, name, course_id, description)
values (40002,'Create a Theory in Maths',20002,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer luctus egestas tempo Aliquam quis nunc nec leo pulvinar laoreet ac a augue. Nam sagittis ipsum non tempor ultricies. Morbi laoreet ante in justo varius congue. Aenean ornare varius');
insert into assignment (id, name, course_id, description)
values (40003,'Create a Theory in Chemistry',20003,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer luctus egestas tempo Aliquam quis nunc nec leo pulvinar laoreet ac a augue. Nam sagittis ipsum non tempor ultricies. Morbi laoreet ante in justo varius congue. Aenean ornare varius');

insert into student (id, name, password)
values (30001,'student1', 'abc123');
insert into student (id, name, password)
values (30002,'student2', 'abc123');
insert into student (id, name, password)
values (30003,'student3', 'abc123');

insert into student_course (student_id,course_id)
values (30001,20001);
insert into student_course (student_id,course_id)
values (30002,20002);
insert into student_course (student_id,course_id)
values (30003,20003);

insert into student_assignment (student_id,assignment_id)
values (30001,40001);
insert into student_assignment (student_id,assignment_id)
values (30002,40002);
insert into student_assignment (student_id,assignment_id)
values (30003,40003);

