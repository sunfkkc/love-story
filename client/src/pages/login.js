import GoogleLoginButton from "@/components/button/GoogleLoginButton";
import { useGoogle } from "@/hooks/auth/useGoogle";
import React from "react";

const LoginPage = () => {
  const onLogin = useGoogle();

  return (
    <div>
      <h2>로그인 하쟝~</h2>
      <GoogleLoginButton callback={onLogin} />
    </div>
  );
};

export default LoginPage;
