package org.rowlandhall.meepmeep.core.util

import com.acmerobotics.roadrunner.geometry.Vector2d

import kotlin.math.min

/**
 * Utility class for field-related coordinate conversions and scaling calculations.
 * Assumes screen coordinates have origin (0,0) at top-left with Y increasing downward,
 * and field coordinates have origin (0,0) at center with Y increasing upward.
 */
class FieldUtil {
    companion object {
        /** Field dimensions in inches (width = X-axis, height = Y-axis) */
        const val DEFAULT_FIELD_WIDTH = 141.0
        const val DEFAULT_FIELD_HEIGHT = 143.0

        // Mutable field dimensions for potential customization
        @JvmStatic var fieldWidth = DEFAULT_FIELD_WIDTH
        @JvmStatic var fieldHeight = DEFAULT_FIELD_HEIGHT

        // Canvas dimensions should be set before using conversion methods
        @JvmStatic var canvasWidth = 0.0
            private set
        @JvmStatic var canvasHeight = 0.0
            private set

        /** Initialize canvas dimensions with validation */
        @JvmStatic
        fun setCanvasDimensions(width: Double, height: Double) {
            require(width > 0 && height > 0) { "Canvas dimensions must be positive" }
            canvasWidth = width
            canvasHeight = height
        }

        /**
         * Converts screen coordinates to field coordinates.
         * @param screenPoint Screen coordinates (origin at top-left)
         * @return Field coordinates (origin at center, Y-up)
         */
        @JvmStatic
        fun screenToField(screenPoint: Vector2d): Vector2d {
            validateCanvasDimensions()
            
            val normalizedX = screenPoint.x / canvasWidth
            val normalizedY = (canvasHeight - screenPoint.y) / canvasHeight
            
            return Vector2d(
                normalizedX * fieldWidth - fieldWidth / 2,
                normalizedY * fieldHeight - fieldHeight / 2
            )
        }

        /**
         * Converts field coordinates to screen coordinates.
         * @param fieldPoint Field coordinates (origin at center, Y-up)
         * @return Screen coordinates (origin at top-left)
         */
        @JvmStatic
        fun fieldToScreen(fieldPoint: Vector2d): Vector2d {
            validateCanvasDimensions()
            
            val normalizedX = (fieldPoint.x + fieldWidth / 2) / fieldWidth
            val normalizedY = (fieldPoint.y + fieldHeight / 2) / fieldHeight
            
            return Vector2d(
                normalizedX * canvasWidth,
                canvasHeight - (normalizedY * canvasHeight)
            )
        }

        /**
         * Scales inches to pixels using current field-to-screen ratio.
         * Maintains aspect ratio using the same scale factor for both axes.
         * @return Pixel equivalent for the given inch measurement
         */
        @JvmStatic
        fun inchesToPixels(inches: Double): Double {
            validateCanvasDimensions()
            
            val widthScale = canvasWidth / fieldWidth
            val heightScale = canvasHeight / fieldHeight
            val uniformScale = min(widthScale, heightScale)
            
            return inches * uniformScale
        }

        private fun validateCanvasDimensions() {
            require(canvasWidth > 0 && canvasHeight > 0) {
                "Canvas dimensions must be set using setCanvasDimensions() before conversions"
            }
        }
    }
}
