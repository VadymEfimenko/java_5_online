CREATE SCHEMA `hw_9_course_students` DEFAULT CHARACTER SET utf8;

create table students
(
    id bigint auto_increment primary key,
    first_name varchar(45),
    last_name varchar(45),
    year int
);

create table courses
(
    id bigint auto_increment primary key,
    title varchar(45),
    mouth_duration int
);

create table course_student
(
    course_id bigint not null,
    student_id bigint not null,
    primary key (course_id, student_id),
    foreign key (course_id) references courses(id),
    foreign key (student_id) references students(id)
)