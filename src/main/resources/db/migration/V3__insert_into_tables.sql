-- Migration script to insert data into 'take_time_day' and 'medicine_type'

-- Inserting into 'medicine_type'
INSERT INTO medicine_type (name) VALUES
                                     ('Ингалятор'), -- Inhaler
                                     ('Порошок'), -- Powder
                                     ('Таблетка'), -- Pill
                                     ('Раствор (Жидкость)'), -- Solution (Liquid)
                                     ('Инъекция'), -- Injection
                                     ('Другое'); -- Other

-- Inserting into 'take_time_day'
INSERT INTO take_time_day (name) VALUES
                                     ('Каждый день'), -- Every day
                                     ('Каждые три дня'), -- Every three days
                                     ('По определенным дням недели'), -- On specific days of the week
                                     ('Каждые X дней'), -- Every X days
                                     ('По повторяющемуся циклу'); -- On a recurring cycle
