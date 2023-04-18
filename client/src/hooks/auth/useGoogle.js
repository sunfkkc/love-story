import { useMutation } from "react-query";

const { client } = require("@/client");

const sendGoogleToken = async (token) => {
  const { data } = await client.post("/api/v1/auth/google", { token });
  return data;
};

export const useGoogle = () => {
  const { mutateAsync } = useMutation(sendGoogleToken);

  const onLogin = async (res) => {
    console.log("로그인 성공 서버로 토큰 전송");
    const data = await mutateAsync(res.credential);
    console.log(data);
  };

  return onLogin;
};
