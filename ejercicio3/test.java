/* Generated By:JavaCC: Do not edit this line. test.java */
class test implements testConstants {
  public static void main(String[] args) throws ParseException{
    try{
      test analizador = new test(System.in);
      analizador.Librerias();
      System.out.println("Se ha compilado con exito");
    }catch(ParseException e){
      System.out.println(e.getMessage());
      System.out.println("Se han encontrado errores");
    }
  }

  static final public void Librerias() throws ParseException {
    label_1:
    while (true) {
      jj_consume_token(NUMERAL);
      jj_consume_token(INCLUDE);
      jj_consume_token(MENOR);
      jj_consume_token(IDENTIFICADOR);
      jj_consume_token(PUNTO);
      jj_consume_token(IDENTIFICADOR);
      jj_consume_token(MAYOR);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMERAL:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    metodoPrincipal();
  }

  static final public void tipoFuncion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case FLOAT:
      jj_consume_token(FLOAT);
      break;
    case STRING:
      jj_consume_token(STRING);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void funcionArgs() throws ParseException {
    jj_consume_token(VOID);
  }

  static final public void funcionReturn() throws ParseException {
    jj_consume_token(REGRESAR);
    Valor();
  }

// Estructura del programa general
  static final public void metodoPrincipal() throws ParseException {
    tipoFuncion();
    jj_consume_token(INICIAL);
    jj_consume_token(PARENTESISIZQ);
    funcionArgs();
    jj_consume_token(PARENTESISDER);
    jj_consume_token(LLAVEIZQ);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MESSAGE:
      case LEER:
      case SISTEMA:
      case IF:
      case SWITCH:
      case ENTERO:
      case DOBLE:
      case CADENA:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      Sentencias();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case REGRESAR:
      funcionReturn();
      jj_consume_token(PUNTOYCOMA);
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
    jj_consume_token(LLAVEDER);
    jj_consume_token(0);
  }

  static final public void Sentencias() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTERO:
    case DOBLE:
    case CADENA:
      declaracionAsignacion();
      break;
    case IF:
      sentenciaIf();
      break;
    case SWITCH:
      sentenciaMenuSi();
      break;
    case MESSAGE:
    case LEER:
    case SISTEMA:
      Acciones();
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void declaracionAsignacion() throws ParseException {
    tipoVariable();
    jj_consume_token(IDENTIFICADOR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASIGNACION:
      jj_consume_token(ASIGNACION);
      Valor();
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(PUNTOYCOMA);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MESSAGE:
    case LEER:
    case SISTEMA:
    case IF:
    case SWITCH:
    case ENTERO:
    case DOBLE:
    case CADENA:
      Sentencias();
      break;
    default:
      jj_la1[6] = jj_gen;
      ;
    }
  }

  static final public void tipoVariable() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ENTERO:
      jj_consume_token(ENTERO);
      break;
    case DOBLE:
      jj_consume_token(DOBLE);
      break;
    case CADENA:
      jj_consume_token(CADENA);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// ---------------

// void VS():
// {}
// {
//     (declaracionAsignacion() <PUNTOYCOMA>)
//   | Sentencias()
// }
  static final public void sentenciaIf() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(PARENTESISIZQ);
    comparacionSimple();
    jj_consume_token(PARENTESISDER);
    jj_consume_token(LLAVEIZQ);
    cuerpoSentencia();
    jj_consume_token(LLAVEDER);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      jj_consume_token(LLAVEIZQ);
      cuerpoSentencia();
      jj_consume_token(LLAVEDER);
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

  static final public void sentenciaMenuSi() throws ParseException {
    jj_consume_token(SWITCH);
    jj_consume_token(PARENTESISIZQ);
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(PARENTESISDER);
    jj_consume_token(LLAVEIZQ);
    label_3:
    while (true) {
      Caso();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CASE:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_3;
      }
    }
    casoPredeterminado();
    jj_consume_token(LLAVEDER);
    Sentencias();
  }

  static final public void Caso() throws ParseException {
    jj_consume_token(CASE);
    Valor();
    jj_consume_token(DOSPUNTOS);
    cuerpoSentencia();
    jj_consume_token(BREAK);
    jj_consume_token(PUNTOYCOMA);
  }

  static final public void casoPredeterminado() throws ParseException {
    jj_consume_token(PREDETERMINADO);
    jj_consume_token(DOSPUNTOS);
    cuerpoSentencia();
    jj_consume_token(BREAK);
    jj_consume_token(PUNTOYCOMA);
  }

  static final public void cuerpoSentencia() throws ParseException {
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MESSAGE:
      case LEER:
      case SISTEMA:
      case IF:
      case SWITCH:
      case ENTERO:
      case DOBLE:
      case CADENA:
        ;
        break;
      default:
        jj_la1[10] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MESSAGE:
      case LEER:
      case SISTEMA:
        Acciones();
        break;
      case IF:
      case SWITCH:
      case ENTERO:
      case DOBLE:
      case CADENA:
        Sentencias();
        break;
      default:
        jj_la1[11] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Acciones() throws ParseException {
    metodosReservados();
    jj_consume_token(PUNTOYCOMA);
  }

// Metodos propios del lenguaje
  static final public void metodosReservados() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LEER:
      jj_consume_token(LEER);
      break;
    case SISTEMA:
      jj_consume_token(SISTEMA);
      break;
    case MESSAGE:
      jj_consume_token(MESSAGE);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(PARENTESISIZQ);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMILLADOB:
      case COMA:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMILLADOB:
        Cadena();
        break;
      case COMA:
        jj_consume_token(COMA);
        jj_consume_token(AMPERSAND);
        jj_consume_token(IDENTIFICADOR);
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(PARENTESISDER);
  }

// Estructura de una Cadena de texto
  static final public void Cadena() throws ParseException {
    jj_consume_token(COMILLADOB);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFICADOR:
        jj_consume_token(IDENTIFICADOR);
        break;
      case NUMERO:
        jj_consume_token(NUMERO);
        break;
      case INCREMENTO:
      case DECREMENTO:
      case MENOR:
      case MAYOR:
      case MENORIGUAL:
      case MAYORIGUAL:
      case IGUAL:
      case DISTINTO:
        operadoresComparacion();
        break;
      case MAS:
      case MENOS:
      case ASTERISCO:
      case BARRA:
      case PORCENTAJE:
        operadoresAritmeticos();
        break;
      case PARENTESISIZQ:
      case PARENTESISDER:
      case LLAVEIZQ:
      case LLAVEDER:
      case NUMERAL:
      case PUNTOYCOMA:
      case DOSPUNTOS:
      case COMA:
      case PUNTO:
      case AMPERSAND:
      case ASIGNACION:
        Simbolos();
        break;
      default:
        jj_la1[15] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PARENTESISIZQ:
      case PARENTESISDER:
      case LLAVEIZQ:
      case LLAVEDER:
      case NUMERAL:
      case PUNTOYCOMA:
      case DOSPUNTOS:
      case COMA:
      case PUNTO:
      case AMPERSAND:
      case ASIGNACION:
      case MAS:
      case MENOS:
      case ASTERISCO:
      case BARRA:
      case PORCENTAJE:
      case INCREMENTO:
      case DECREMENTO:
      case MENOR:
      case MAYOR:
      case MENORIGUAL:
      case MAYORIGUAL:
      case IGUAL:
      case DISTINTO:
      case NUMERO:
      case IDENTIFICADOR:
        ;
        break;
      default:
        jj_la1[16] = jj_gen;
        break label_6;
      }
    }
    jj_consume_token(COMILLADOB);
  }

  static final public void usoIncremento() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(INCREMENTO);
  }

  static final public void usoDecremento() throws ParseException {
    jj_consume_token(IDENTIFICADOR);
    jj_consume_token(DECREMENTO);
  }

  static final public void comparacionSimple() throws ParseException {
    Valor();
    operadoresComparacion();
    Valor();
  }

// Tipos de valores
  static final public void Valor() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFICADOR:
      jj_consume_token(IDENTIFICADOR);
      break;
    case NUMERO:
      jj_consume_token(NUMERO);
      break;
    case COMILLADOB:
      Cadena();
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAS:
    case MENOS:
    case ASTERISCO:
    case BARRA:
    case PORCENTAJE:
      operadoresAritmeticos();
      jj_consume_token(NUMERO);
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
  }

  static final public void operadoresComparacion() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MENOR:
      jj_consume_token(MENOR);
      break;
    case MAYOR:
      jj_consume_token(MAYOR);
      break;
    case IGUAL:
      jj_consume_token(IGUAL);
      break;
    case DISTINTO:
      jj_consume_token(DISTINTO);
      break;
    case MENORIGUAL:
      jj_consume_token(MENORIGUAL);
      break;
    case MAYORIGUAL:
      jj_consume_token(MAYORIGUAL);
      break;
    case INCREMENTO:
      jj_consume_token(INCREMENTO);
      break;
    case DECREMENTO:
      jj_consume_token(DECREMENTO);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void operadoresAritmeticos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MAS:
      jj_consume_token(MAS);
      break;
    case MENOS:
      jj_consume_token(MENOS);
      break;
    case ASTERISCO:
      jj_consume_token(ASTERISCO);
      break;
    case BARRA:
      jj_consume_token(BARRA);
      break;
    case PORCENTAJE:
      jj_consume_token(PORCENTAJE);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Simbolos() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMERAL:
      jj_consume_token(NUMERAL);
      break;
    case COMA:
      jj_consume_token(COMA);
      break;
    case PUNTO:
      jj_consume_token(PUNTO);
      break;
    case DOSPUNTOS:
      jj_consume_token(DOSPUNTOS);
      break;
    case PUNTOYCOMA:
      jj_consume_token(PUNTOYCOMA);
      break;
    case PARENTESISIZQ:
      jj_consume_token(PARENTESISIZQ);
      break;
    case PARENTESISDER:
      jj_consume_token(PARENTESISDER);
      break;
    case LLAVEIZQ:
      jj_consume_token(LLAVEIZQ);
      break;
    case LLAVEDER:
      jj_consume_token(LLAVEDER);
      break;
    case AMPERSAND:
      jj_consume_token(AMPERSAND);
      break;
    case ASIGNACION:
      jj_consume_token(ASIGNACION);
      break;
    default:
      jj_la1[21] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public testTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[22];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x200000,0x0,0x5c8,0x10,0x5c8,0x10000000,0x5c8,0x0,0x200,0x800,0x5c8,0x5c8,0xc8,0x3000000,0x3000000,0xfefe0000,0xfefe0000,0x1000000,0xe0000000,0x0,0xe0000000,0x1efe0000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x70000,0xe000,0x0,0xe000,0x0,0xe000,0xe000,0x0,0x0,0xe000,0xe000,0x0,0x0,0x0,0x1803ff,0x1803ff,0x180000,0x3,0x3fc,0x3,0x0,};
   }

  /** Constructor with InputStream. */
  public test(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public test(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new testTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public test(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new testTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public test(testTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(testTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 22; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[59];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 22; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 59; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
