PGDMP     %                    {         
   vacunacion    14.5    14.4 *               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    17163 
   vacunacion    DATABASE     h   CREATE DATABASE vacunacion WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Bolivia.1252';
    DROP DATABASE vacunacion;
                postgres    false            �            1259    17164    rol    TABLE     [   CREATE TABLE public.rol (
    id_rol integer NOT NULL,
    nombre character varying(30)
);
    DROP TABLE public.rol;
       public         heap    postgres    false            �            1259    17167    rol_id_rol_seq    SEQUENCE     �   CREATE SEQUENCE public.rol_id_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.rol_id_rol_seq;
       public          postgres    false    209                       0    0    rol_id_rol_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.rol_id_rol_seq OWNED BY public.rol.id_rol;
          public          postgres    false    210            �            1259    17168    usuario    TABLE     �  CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    id_rol integer NOT NULL,
    ci integer,
    apellidos character varying(50),
    nombres character varying(50),
    correo character varying(40),
    fecha_nacimiento date,
    direccion character varying(50),
    telefono character varying(15),
    usuario character varying(50),
    password character varying(50)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �            1259    17171    usuario_id_usuario_seq    SEQUENCE     �   CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.usuario_id_usuario_seq;
       public          postgres    false    211                       0    0    usuario_id_usuario_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;
          public          postgres    false    212            �            1259    17172    vacuna    TABLE     a   CREATE TABLE public.vacuna (
    id_vacuna integer NOT NULL,
    nombre character varying(30)
);
    DROP TABLE public.vacuna;
       public         heap    postgres    false            �            1259    17175    vacuna_id_vacuna_seq    SEQUENCE     �   CREATE SEQUENCE public.vacuna_id_vacuna_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.vacuna_id_vacuna_seq;
       public          postgres    false    213                       0    0    vacuna_id_vacuna_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.vacuna_id_vacuna_seq OWNED BY public.vacuna.id_vacuna;
          public          postgres    false    214            �            1259    17176 
   vacunacion    TABLE     �   CREATE TABLE public.vacunacion (
    id_vacunacion integer NOT NULL,
    id_vacuna integer NOT NULL,
    id_usuario integer NOT NULL,
    fecha date,
    estado character varying(30),
    dosis integer
);
    DROP TABLE public.vacunacion;
       public         heap    postgres    false            �            1259    17179    vacunacion_id_vacunacion_seq    SEQUENCE     �   CREATE SEQUENCE public.vacunacion_id_vacunacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.vacunacion_id_vacunacion_seq;
       public          postgres    false    215                       0    0    vacunacion_id_vacunacion_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.vacunacion_id_vacunacion_seq OWNED BY public.vacunacion.id_vacunacion;
          public          postgres    false    216            k           2604    17180 
   rol id_rol    DEFAULT     h   ALTER TABLE ONLY public.rol ALTER COLUMN id_rol SET DEFAULT nextval('public.rol_id_rol_seq'::regclass);
 9   ALTER TABLE public.rol ALTER COLUMN id_rol DROP DEFAULT;
       public          postgres    false    210    209            l           2604    17181    usuario id_usuario    DEFAULT     x   ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);
 A   ALTER TABLE public.usuario ALTER COLUMN id_usuario DROP DEFAULT;
       public          postgres    false    212    211            m           2604    17182    vacuna id_vacuna    DEFAULT     t   ALTER TABLE ONLY public.vacuna ALTER COLUMN id_vacuna SET DEFAULT nextval('public.vacuna_id_vacuna_seq'::regclass);
 ?   ALTER TABLE public.vacuna ALTER COLUMN id_vacuna DROP DEFAULT;
       public          postgres    false    214    213            n           2604    17183    vacunacion id_vacunacion    DEFAULT     �   ALTER TABLE ONLY public.vacunacion ALTER COLUMN id_vacunacion SET DEFAULT nextval('public.vacunacion_id_vacunacion_seq'::regclass);
 G   ALTER TABLE public.vacunacion ALTER COLUMN id_vacunacion DROP DEFAULT;
       public          postgres    false    216    215                      0    17164    rol 
   TABLE DATA           -   COPY public.rol (id_rol, nombre) FROM stdin;
    public          postgres    false    209   /.                 0    17168    usuario 
   TABLE DATA           �   COPY public.usuario (id_usuario, id_rol, ci, apellidos, nombres, correo, fecha_nacimiento, direccion, telefono, usuario, password) FROM stdin;
    public          postgres    false    211   e.                 0    17172    vacuna 
   TABLE DATA           3   COPY public.vacuna (id_vacuna, nombre) FROM stdin;
    public          postgres    false    213   /                 0    17176 
   vacunacion 
   TABLE DATA           `   COPY public.vacunacion (id_vacunacion, id_vacuna, id_usuario, fecha, estado, dosis) FROM stdin;
    public          postgres    false    215   ^/                  0    0    rol_id_rol_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.rol_id_rol_seq', 1, false);
          public          postgres    false    210                       0    0    usuario_id_usuario_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 19, true);
          public          postgres    false    212                        0    0    vacuna_id_vacuna_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.vacuna_id_vacuna_seq', 1, false);
          public          postgres    false    214            !           0    0    vacunacion_id_vacunacion_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.vacunacion_id_vacunacion_seq', 1, false);
          public          postgres    false    216            p           2606    17185 
   rol pk_rol 
   CONSTRAINT     L   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT pk_rol PRIMARY KEY (id_rol);
 4   ALTER TABLE ONLY public.rol DROP CONSTRAINT pk_rol;
       public            postgres    false    209            s           2606    17187    usuario pk_usuario 
   CONSTRAINT     X   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (id_usuario);
 <   ALTER TABLE ONLY public.usuario DROP CONSTRAINT pk_usuario;
       public            postgres    false    211            w           2606    17189    vacuna pk_vacuna 
   CONSTRAINT     U   ALTER TABLE ONLY public.vacuna
    ADD CONSTRAINT pk_vacuna PRIMARY KEY (id_vacuna);
 :   ALTER TABLE ONLY public.vacuna DROP CONSTRAINT pk_vacuna;
       public            postgres    false    213            {           2606    17191    vacunacion pk_vacunacion 
   CONSTRAINT     a   ALTER TABLE ONLY public.vacunacion
    ADD CONSTRAINT pk_vacunacion PRIMARY KEY (id_vacunacion);
 B   ALTER TABLE ONLY public.vacunacion DROP CONSTRAINT pk_vacunacion;
       public            postgres    false    215            y           1259    17192    contiene_fk    INDEX     G   CREATE INDEX contiene_fk ON public.vacunacion USING btree (id_vacuna);
    DROP INDEX public.contiene_fk;
       public            postgres    false    215            t           1259    17193    posee_fk    INDEX     >   CREATE INDEX posee_fk ON public.usuario USING btree (id_rol);
    DROP INDEX public.posee_fk;
       public            postgres    false    211            |           1259    17194 	   recibe_fk    INDEX     F   CREATE INDEX recibe_fk ON public.vacunacion USING btree (id_usuario);
    DROP INDEX public.recibe_fk;
       public            postgres    false    215            q           1259    17195    rol_pk    INDEX     ?   CREATE UNIQUE INDEX rol_pk ON public.rol USING btree (id_rol);
    DROP INDEX public.rol_pk;
       public            postgres    false    209            u           1259    17196 
   usuario_pk    INDEX     K   CREATE UNIQUE INDEX usuario_pk ON public.usuario USING btree (id_usuario);
    DROP INDEX public.usuario_pk;
       public            postgres    false    211            x           1259    17197 	   vacuna_pk    INDEX     H   CREATE UNIQUE INDEX vacuna_pk ON public.vacuna USING btree (id_vacuna);
    DROP INDEX public.vacuna_pk;
       public            postgres    false    213            }           1259    17198    vacunacion_pk    INDEX     T   CREATE UNIQUE INDEX vacunacion_pk ON public.vacunacion USING btree (id_vacunacion);
 !   DROP INDEX public.vacunacion_pk;
       public            postgres    false    215            ~           2606    17199    usuario fk_usuario_posee_rol    FK CONSTRAINT     �   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_usuario_posee_rol FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol) ON UPDATE RESTRICT ON DELETE RESTRICT;
 F   ALTER TABLE ONLY public.usuario DROP CONSTRAINT fk_usuario_posee_rol;
       public          postgres    false    209    211    3184                       2606    17204 &   vacunacion fk_vacunaci_contiene_vacuna    FK CONSTRAINT     �   ALTER TABLE ONLY public.vacunacion
    ADD CONSTRAINT fk_vacunaci_contiene_vacuna FOREIGN KEY (id_vacuna) REFERENCES public.vacuna(id_vacuna) ON UPDATE RESTRICT ON DELETE RESTRICT;
 P   ALTER TABLE ONLY public.vacunacion DROP CONSTRAINT fk_vacunaci_contiene_vacuna;
       public          postgres    false    215    3191    213            �           2606    17209 %   vacunacion fk_vacunaci_recibe_usuario    FK CONSTRAINT     �   ALTER TABLE ONLY public.vacunacion
    ADD CONSTRAINT fk_vacunaci_recibe_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.vacunacion DROP CONSTRAINT fk_vacunaci_recibe_usuario;
       public          postgres    false    211    215    3187               &   x�3�tL����,.)JL�/�2�t�-�I��b���� ��	�         �   x�}���0E�ׯ�K�:j01�Y���TX�zq�E������=(P;�i����U(�3ǰ���0O����r��aG�_�f@v����:@��i((Rd�ѳ���1�+�Fv4Nl{U��}��t���i��7���P����*!�v�F8         <   x�3�.(-����2�t,.)J�J�KMN�2�HˬJ-�2�����+��SPS���b���� 4�         G   x�3�4�44�4202�50"ΰ��ҼĔ|N#.#��9H�P�(o��4�2�4�4���4�#�4����� v��     