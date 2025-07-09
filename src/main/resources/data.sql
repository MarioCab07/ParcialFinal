INSERT INTO usuarios (id, nombre, correo, password, nombre_rol) VALUES
  (10, 'mario', 'mario@test.com',
   '$2a$10$kmXtDszCsmFGKqyg.iNDWuOL5L46mwJRPX69Wx4iErl2gJwPnQx4K',
   'USER')
ON CONFLICT (id) DO NOTHING;

INSERT INTO usuarios (id, nombre, correo, password, nombre_rol) VALUES
  (11, 'gabyu', 'gaby@test.com',
   '$2a$10$kmXtDszCsmFGKqyg.iNDWuOL5L46mwJRPX69Wx4iErl2gJwPnQx4K',
   'TECH')
ON CONFLICT (id) DO NOTHING;
