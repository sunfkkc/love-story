import useHello from '@/domain/hello/useHello';
import { Inter } from 'next/font/google';

const inter = Inter({ subsets: ['latin'] });

export default function Home() {
  const { mutate } = useHello();
  return (
    <>
      홈<button onClick={() => mutate()}>hello</button>
    </>
  );
}
