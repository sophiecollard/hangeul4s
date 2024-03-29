package hangeul4s.model.romanization

import hangeul4s.encoding.{Decoder, Encoder}
import hangeul4s.error.DecodingFailure

/**
  * Roman letters used in the revised romanization of Korean.
  *
  * Note that letters F, Q, V, X and Z are never and therefore omitted.
  */
sealed abstract class RomanLetter private [romanization] (val char: Char) {

  override def toString: String =
    s"hangeul4s.model.romanization.RomanLetter($char)"

}

object RomanLetter {

  final case object A extends RomanLetter('a')
  final case object B extends RomanLetter('b')
  final case object C extends RomanLetter('c')
  final case object D extends RomanLetter('d')
  final case object E extends RomanLetter('e')
  final case object G extends RomanLetter('g')
  final case object H extends RomanLetter('h')
  final case object I extends RomanLetter('i')
  final case object J extends RomanLetter('j')
  final case object K extends RomanLetter('k')
  final case object L extends RomanLetter('l')
  final case object M extends RomanLetter('m')
  final case object N extends RomanLetter('n')
  final case object O extends RomanLetter('o')
  final case object P extends RomanLetter('p')
  final case object R extends RomanLetter('r')
  final case object S extends RomanLetter('s')
  final case object T extends RomanLetter('t')
  final case object U extends RomanLetter('u')
  final case object W extends RomanLetter('w')
  final case object Y extends RomanLetter('y')

  implicit val charDecoder: Decoder[Char, RomanLetter] =
    Decoder.instance {
      case 'A' | 'a' => Right(A)
      case 'B' | 'b' => Right(B)
      case 'C' | 'c' => Right(C)
      case 'D' | 'd' => Right(D)
      case 'E' | 'e' => Right(E)
      case 'G' | 'g' => Right(G)
      case 'H' | 'h' => Right(H)
      case 'I' | 'i' => Right(I)
      case 'J' | 'j' => Right(J)
      case 'K' | 'k' => Right(K)
      case 'L' | 'l' => Right(L)
      case 'M' | 'm' => Right(M)
      case 'N' | 'n' => Right(N)
      case 'O' | 'o' => Right(O)
      case 'P' | 'p' => Right(P)
      case 'R' | 'r' => Right(R)
      case 'S' | 's' => Right(S)
      case 'T' | 't' => Right(T)
      case 'U' | 'u' => Right(U)
      case 'W' | 'w' => Right(W)
      case 'Y' | 'y' => Right(Y)
      case c         => Left(DecodingFailure.FailedToDecodeRomanLetter(c))
    }

  implicit val charEncoder: Encoder[RomanLetter, Char] =
    Encoder.instance(_.char)

}
