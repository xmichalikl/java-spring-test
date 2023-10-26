insert into "campaign" ("id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086aed');

insert into "question" ("id","campaign_id","type", "text") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 'a9cf9e86-e7a5-4934-bbed-8aa03a086aed', 'RATING', 'Rating question');

insert into "question" ("id","campaign_id","type", "text") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086aed', 'CHOICE', 'Choice question');

insert into "option" ("id","question_id", "text") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae3','a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'Option 1');
insert into "option" ("id","question_id", "text") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae4','a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'Option 2');
insert into "option" ("id","question_id", "text") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae5','a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'Option 3');
insert into "option" ("id","question_id", "text") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae6','a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'Option 4');

-- feedback 1
insert into "feedback" ("id", "campaign_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 'a9cf9e86-e7a5-4934-bbed-8aa03a086aed');
insert into "answer" ("id", "feedback_id", "question_id", "rating_value") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 5);
insert into "answer" ("id", "feedback_id", "question_id", "rating_value") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 0);
insert into "answer_selected_option" ("answer_id", "option_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae4');

-- feedback 2
insert into "feedback" ("id", "campaign_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086aed');
insert into "answer" ("id", "feedback_id", "question_id", "rating_value") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ac1', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 3);
insert into "answer" ("id", "feedback_id", "question_id", "rating_value") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ac2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 0);
insert into "answer_selected_option" ("answer_id", "option_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ac2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae4');
insert into "answer_selected_option" ("answer_id", "option_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ac2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae6');

-- feedback 3
insert into "feedback" ("id", "campaign_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ae3', 'a9cf9e86-e7a5-4934-bbed-8aa03a086aed');
insert into "answer" ("id", "feedback_id", "question_id", "rating_value") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ad1', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae3', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae1', 4);
insert into "answer" ("id", "feedback_id", "question_id", "rating_value") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ad2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae3', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae2', 0);
insert into "answer_selected_option" ("answer_id", "option_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ad2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae4');
insert into "answer_selected_option" ("answer_id", "option_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ad2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae6');
insert into "answer_selected_option" ("answer_id", "option_id") values ('a9cf9e86-e7a5-4934-bbed-8aa03a086ad2', 'a9cf9e86-e7a5-4934-bbed-8aa03a086ae3');