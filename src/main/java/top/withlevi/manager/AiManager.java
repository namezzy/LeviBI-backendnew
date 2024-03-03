package top.withlevi.manager;


import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;
import top.withlevi.common.ErrorCode;
import top.withlevi.exception.BusinessException;

import javax.annotation.Resource;

@Service
public class AiManager {


    @Resource
    private YuCongMingClient yuCongMingClient;


    /**
     * AI 对话
     * @param message
     * @return
     */
    public String doChat(String message) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1651468516836098050L);
        devChatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);

        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI响应错误");
        }

        return response.getData().getContent();


    }


}
