create table PETS (
id SERIAL PRIMARY KEY,
name text,
pet_type INT REFERENCES types_pets(id)
)