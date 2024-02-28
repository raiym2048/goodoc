
alter table if exists medicine add constraint FK6jo8tdud51x538342ecwx9rj5 foreign key (take_time_id) references take_time
    ;alter table if exists medicine add constraint FKinhaj3lokxnc8fif7r9hkhh1d foreign key (type_id) references medicine_type
    ;alter table if exists take_time add constraint FKejb6jpwffl1luu8k8x2dtwdft foreign key (day_id) references take_time_day
    ;alter table if exists users_medicines add constraint FK9pdwbl9lpuhqq9sgf943c420e foreign key (medicines_id) references medicine
    ;alter table if exists users_medicines add constraint FKp68ec1eb5jckm57f6ltfddn9f foreign key (user_id) references users;